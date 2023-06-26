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
    var filterCourses: [Course] = []
    
    @IBOutlet weak var coursesSearch: UISearchBar!
    
    
    //trimite utilizatorul la partea de setari
    @IBAction func settings(_ sender: Any) {
        performSegue(withIdentifier: "goToSettingsSeque", sender: nil)
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
        loadCourses()
       
        coursesSearch.delegate = self
        
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
                filterCourses = response
                tableView.reloadData()
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
}

extension CoursesViewController: UITableViewDelegate, UITableViewDataSource, UISearchBarDelegate {
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
    
    func searchBar(_ searchBar: UISearchBar, textDidChange searchText: String) {
        if searchText != "" {
                // se filtreaza vectorul courses in functie de searchText
            let filteredCourses = courses.filter { $0.name.lowercased().contains(searchText.lowercased()) }
                
                // se actualizeaza vectorul courses cu noile rezultate filtrate
                courses = filteredCourses
                
                // se reincarca tableView cu noile rezultate
                tableView.reloadData()
            } else {
                // Dacă searchBar-ul este gol, se afiseaza toate cursurile
                courses = filterCourses
                
                // se reincarca tableView cu toate cursurile
                tableView.reloadData()
            }
    }
    
    //folosita in momentul in care utilizatorul selecteaza un curs
    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        performSegue(withIdentifier: "goToChaptersSegue", sender: indexPath.row)
    }
}
