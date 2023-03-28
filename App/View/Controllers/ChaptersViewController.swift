//
//  ChaptersController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 18.03.2023.
//

import Foundation
import UIKit

class ChaptersViewController: UIViewController {


  
    @IBAction func goToContent(_ sender: Any) {
        performSegue(withIdentifier: "goToContentChapterSeque", sender: nil)
    }
    @IBOutlet weak var tableView: UITableView!
    var chapters: [Chapter] = []

    override func viewDidLoad() {
        super.viewDidLoad()
        loadChapters()
    }
    
    func loadChapters() {
        let service = AppService()
        Task(priority: .background) {
            let result = await service.getChapters()
            switch result {
            case .success(let response):
                print("Capitolele au fost aduse cu succes \(response)")
                chapters = response
                tableView.reloadData()
                
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
}

extension ChaptersViewController: UITableViewDelegate, UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return chapters.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell  = tableView.dequeueReusableCell(withIdentifier: "ChapterCell", for: indexPath) as? ChapterCell {
            cell.configure(title: chapters[indexPath.row].name, image: chapters[indexPath.row].image, initialdescription: chapters[indexPath.row].initialdescription)
            cell.layer.borderWidth = 1
            cell.layer.cornerRadius = 20
            return cell
        }
        return UITableViewCell()
    }
    
    func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return tableView.frame.height
    }
}

//extension ChaptersViewController: UITableViewDelegate {
//    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
//        return CGSize(width: UIScreen.main.bounds.width - 40, height: UIScreen.main.bounds.height/1.3)
//    }
//}
//
//extension ChaptersViewController: UIScrollViewDelegate {
//    func scrollViewDidEndDecelerating(_ scrollView: UIScrollView) {
//        self.collectionView.scrollToNearestVisibleCollectionViewCell()
//
//    }
//
//    func scrollViewDidEndDragging(_ scrollView: UIScrollView, willDecelerate decelerate: Bool) {
//        if !decelerate {
//            self.collectionView.scrollToNearestVisibleCollectionViewCell()
//        }
//    }
//    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath){
//        performSegue(withIdentifier: "goToContentChapterSeque", sender: nil)
//    }
//
//}
