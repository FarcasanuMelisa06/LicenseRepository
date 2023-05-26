//
//  Endpoint.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 15.03.2023.
//

import Foundation

protocol Endpoint: ManagerInjector {
    var scheme: String { get }
    var host: String { get }
    var path: String { get }
    var method: RequestMethod { get }
    var header: [String: String]? { get }
    var body: [String: Any]? { get }
    var port: Int? { get }
    var languagePath: String { get }
}

extension Endpoint {
    var scheme: String {
        return "http"
    }
    
    var header: [String: String]? {
        return ["Content-Type": "application/json"]
    }
    
    var host: String {
         return "localhost"
         //return "192.168.1.2"
        //return "172.20.10.2"
    }
    
    var port: Int? {
        return 8080
    }
    
    var languagePath: String {
        return manager.language ?? AppLanguage.romanian.rawValue
    }
}
