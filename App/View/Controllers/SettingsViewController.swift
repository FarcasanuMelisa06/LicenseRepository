//
//  SettingsViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 06.04.2023.
//

import Foundation
import UIKit

class SettingsViewController: UIViewController, ManagerInjector {
    
    @IBOutlet weak var languageSwitch: UISwitch!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        initUI()
        self.setupHideKeyboardOnTap()
    }
    
    @IBAction func switchLanguage(_ sender: Any) {
        if languageSwitch.isOn {
            manager.language = AppLanguage.english.rawValue
        } else {
            manager.language = AppLanguage.romanian.rawValue
        }
    }
    
    private func initUI() {
        languageSwitch.isOn = manager.language == AppLanguage.english.rawValue ? true : false
    }
}
