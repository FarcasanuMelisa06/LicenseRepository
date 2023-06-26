//
//  CoursesListViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 16.03.2023.
//

import Foundation
import UIKit

class CoursesViewController: UIViewController {
    
    @IBOutlet weak var tableView: UITableView!
    var courses: [Course] = []
    
    //trimite utilizatorul la partea de setari
    @IBAction func settings(_ sender: Any) {
        performSegue(withIdentifier: "goToSettingsSeque", sender: nil)
    }
    
    @IBAction func search(_ sender: Any) {
        performSegue(withIdentifier: "goToSearchSeque", sender: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadCourses()
        self.setupHideKeyboardOnTap()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        switch segue.identifier {
        case "goToChaptersSegue":
            
            let controller = segue.destination as? ChaptersViewController
            if let index = sender as? Int {
                controller?.courseId = courses[index].id
            }
            default: break
        }
    }
    
    func loadCourses() {
        let service = AppService()
        Task(priority: .background) {
            let result = await service.getCourses()
            switch result {
            case .success(let response):
                print("Cursurile au fost aduse cu succes \(response)")
                courses = response
                tableView.reloadData()
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
}

extension CoursesViewController: UITableViewDelegate, UITableViewDataSource {
    //returneaza numarul de randuri din vectorul "courses"
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return courses.count
    }
    
    //returneaza o celula pentru un anumite indexPath care surprinde informatiile despre un curs
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell  = tableView.dequeueReusableCell(withIdentifier: "CourseCell", for: indexPath) as? CourseCell {
            
            cell.configure(title: courses[indexPath.row].name)
            cell.layer.borderWidth = 1
            cell.layer.cornerRadius = 25
            
            return cell
        }
        return UITableViewCell()
    }
    
    //folosita in momentul in care utilizatorul selecteaza un curs
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "goToChaptersSegue", sender: indexPath.row)
    }
}
