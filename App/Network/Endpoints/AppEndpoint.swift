//
//  UserEndpoint.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 15.03.2023.
//

import Foundation

enum AppEndpoint {
    case login(username: String, password: String)
    case courses
    case chapters
}

extension AppEndpoint: Endpoint {
    
    var path: String {
        switch self {
        case .login:
            return "/api/login"
        case .courses:
            return "/api/courses"
        case .chapters:
            return "/api/chapters"
        }
    }

    var method: RequestMethod {
        switch self {
        case .login:
            return .post
        case .courses, .chapters:
            return .get
        }
    }
    
    var body: [String: Any]? {
        switch self {
        case .login(let username, let password):
            return ["username": "\(username)",
                    "password": "\(password)"
            ]
        case .courses, .chapters:
            return nil
        }
    }
}
