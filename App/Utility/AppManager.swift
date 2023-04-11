//
//  AppManager.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 10.04.2023.
//

import Foundation

protocol ManagerInjector {
    var manager: Manager { get }
}

private let sharedInstance: Manager = Manager()

extension ManagerInjector {
    var manager: Manager {
        return sharedInstance
    }
}

enum AppLanguage: String {
    case romanian = "ro"
    case english = "en"
}

class Manager {
    
    let defaults = UserDefaults.standard
    
    internal var language: String? {
        get {
            return self.defaults.string(forKey: "language")
        } set {
            self.defaults.set(newValue, forKey: "language")
        }
    }
}
