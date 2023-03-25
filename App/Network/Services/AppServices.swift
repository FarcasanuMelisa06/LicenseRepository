//
//  AppServices.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 16.03.2023.
//

import Foundation

struct AppService: HTTPClient {
    
    func login(username: String, password: String) async -> Result<User, RequestError> {
        return await sendRequest(endpoint: AppEndpoint.login(username: username, password: password), responseModel: User.self)
    }
    
    func getCourses() async -> Result<[Course], RequestError> {
        return await sendRequest(endpoint: AppEndpoint.courses, responseModel: [Course].self)
    }
    
    func getChapters() async -> Result<[Chapter], RequestError> {
        return await sendRequest(endpoint: AppEndpoint.chapters, responseModel: [Chapter].self)
    }
}
