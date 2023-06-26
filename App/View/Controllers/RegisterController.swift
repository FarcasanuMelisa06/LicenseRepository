//
//  RegisterController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 26.04.2023.
//

import Foundation
import UIKit

class RegisterController: UIViewController, ManagerInjector {
    
    @IBOutlet weak var usernameRegister: UITextField!
    @IBOutlet weak var passwordRegister: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.setupHideKeyboardOnTap()
    }
    
    @IBAction func createAccount(_ sender: Any) {
        let service = AppService()
        Task(priority: .background) {
            let result = await service.register(username: usernameRegister.text ?? "", password: passwordRegister.text ?? "")
            switch result {
            case .success(let response):
                print("Register cu succes \(response.token)")
                manager.token = response.token
                performSegue(withIdentifier: "goToCoursesSegue", sender: nil)
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
}
