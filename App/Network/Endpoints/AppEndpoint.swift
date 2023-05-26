//
//  UserEndpoint.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 15.03.2023.
//

import Foundation

enum AppEndpoint {
    case login(username: String, password: String)
    case register(username: String, password: String)
    case courses
    case chapters
    case chapter(id: Int)
}

extension AppEndpoint: Endpoint {
    
    var path: String {
        switch self {
        case .login:
            return "/api/login"
        case .register:
            return "/api/register"
        case .courses:
            return "/api/courses/\(languagePath)"
        case .chapters:
            return "/api/chapters/\(languagePath)"
        case .chapter(let id):
            return "/api/chapters/\(id)/\(languagePath)"
        }
    }

    var method: RequestMethod {
        switch self {
        case .login, .register:
            return .post
        case .courses, .chapters, .chapter:
            return .get
        }
    }
    
    var body: [String: Any]? {
        switch self {
        case .login(let username, let password):
            return ["username": "\(username)",
                    "password": "\(password)"
            ]
        case .register(let username, let password):
            return ["username": "\(username)",
                    "password": "\(password)"
            ]
        case .courses, .chapters, .chapter:
            return nil
        }
    }
}
