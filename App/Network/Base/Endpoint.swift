//
//  Endpoint.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 15.03.2023.
//

import Foundation

protocol Endpoint {
    var scheme: String { get }
    var host: String { get }
    var path: String { get }
    var method: RequestMethod { get }
    var header: [String: String]? { get }
    var body: [String: Any]? { get }
    var port: Int? { get }
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
    }
    
    var port: Int? {
        return 8080
    }
}
