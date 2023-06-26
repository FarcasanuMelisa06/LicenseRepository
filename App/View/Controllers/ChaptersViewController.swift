//
//  ChaptersController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 18.03.2023.
//

import Foundation
import UIKit

class ChaptersViewController: UIViewController {

    @IBOutlet weak var tableView: UITableView!
    var chapters: [Chapter] = []
    
    var courseId: Int?
    
    //trimite utilizatorul in pagina de setari
    @IBAction func settings(_ sender: Any) {
        performSegue(withIdentifier: "goToSettingsSeque", sender: nil)
    }
    @IBAction func search(_ sender: Any) {
        performSegue(withIdentifier: "goToSearchSeque", sender: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadChapters()
        //functie pentru ascunderea tastaturii
        self.setupHideKeyboardOnTap()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "goToContentChapterSegue":
            
            let controller = segue.destination as? ContentChaptersViewController
            if let id = sender as? Int {
               controller?.chapterTitle = chapters[id].name
                controller?.chapterId = chapters[id].id
            }
            default: break
        }
    }
    
    func loadChapters() {
        if let id = courseId {
            let service = AppService()
            Task(priority: .background) {
                let result = await service.getChapters(id: id)
                switch result {
                case .success(let response):
                    print("Capitolele au fost aduse cu succes \(response)")
                    chapters = response.sorted(by: { $0.id < $1.id })
                    tableView.reloadData()
                case .failure(let error):
                    print("Eroare \(error)")
                }
            }
        }
    }
}

extension ChaptersViewController: UITableViewDelegate, UITableViewDataSource {
    
    //returneaza numarul de randuri din vectorul "courses"
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return chapters.count
    }
    
    //returneaza o celula pentru un anumite indexPath care surprinde informatiile despre un capitol
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell  = tableView.dequeueReusableCell(withIdentifier: "ChapterCell", for: indexPath) as? ChapterCell {
            cell.configure(title: chapters[indexPath.row].name, image: chapters[indexPath.row].image, initialdescription: chapters[indexPath.row].initialdescription)
            cell.layer.borderWidth = 3
            cell.layer.cornerRadius = 20
            cell.onPressReadMore = { [weak self] title in
                self?.performSegue(withIdentifier: "goToContentChapterSegue", sender: indexPath.row)
            }
            
            return cell
        }
        return UITableViewCell()
    }
    
    //returneaza dimensiunea pentru tableView
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return tableView.frame.height
    }
}
