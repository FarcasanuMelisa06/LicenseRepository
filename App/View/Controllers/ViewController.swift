//
//  ViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 10.03.2023.
//

import UIKit
import AVFoundation

class ViewController: UIViewController, ManagerInjector {

    @IBOutlet weak var txtUsername: UITextField!
    @IBOutlet weak var txtPassword: UITextField!
    
    @IBOutlet weak var register: UIButton!
    @IBOutlet weak var login: UIButton!
    @IBOutlet weak var nameApp: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //txtUsername.layer.borderWidth = 1
        txtUsername.layer.cornerRadius = 40
        txtPassword.layer.cornerRadius = 100
        
        login.layer.cornerRadius = 20
        register.layer.cornerRadius = 20
        
        initLanguage()
        

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
    
    private func initLanguage() {
        guard let _ = manager.language else {
            manager.language = AppLanguage.romanian.rawValue
            return
        }
    }
}

