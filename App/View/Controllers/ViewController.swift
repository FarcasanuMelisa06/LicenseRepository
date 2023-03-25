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
   
}

