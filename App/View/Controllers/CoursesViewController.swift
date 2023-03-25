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
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadCourses()
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
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return courses.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        if let cell  = tableView.dequeueReusableCell(withIdentifier: "CourseCell", for: indexPath) as? CourseCell {
            cell.configure(title: courses[indexPath.row].name)
            return cell
        }
        return UITableViewCell()
    }
    
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "goToChaptersSegue", sender: nil)
    }
}