//
//  ViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 10.03.2023.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var txtUsername: UITextField!
    @IBOutlet weak var txtPassword: UITextField!
    
    //var users: [User] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    @IBAction func btnLogin(_ sender: Any) {
        
        let service = AppService()
        Task(priority: .background) {
            let result = await service.login(username: txtUsername.text ?? "", password: txtPassword.text ?? "")
            switch result {
            case .success(let response):
                print("Login cu succes \(response.token)")
                performSegue(withIdentifier: "goToCoursesSegue", sender: self)
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
   
//    //metoda de inregistrare
//    func register(username: String, password: String) -> Bool {
//       return true
//    }
//
//    //metoda de resetare a parolei
//    func resetPassword(username: String, newPassword: String) -> Bool {
//        return true
//    }
//
//        //metoda de actualizare a informatiilor
//    func updateProfile(username: String, password: String) -> Bool {
//        return true
//    }
}

