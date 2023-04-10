//
//  ContentChaptersViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 25.03.2023.
//

import Foundation
import UIKit

class ContentChaptersViewController: UIViewController {
    
    @IBOutlet weak var chapterName: UILabel!
    @IBOutlet weak var content: UILabel!
    
    @IBAction func settings(_ sender: Any) {
        performSegue(withIdentifier: "goToSettingsSeque", sender: nil)
    }
    
    var chapterTitle = ""
    var chapter: Chapter?
    var chapterId: Int?

    override func viewDidLoad() {
        super.viewDidLoad()
        loadChaptersContent()
        chapterName.text = chapterTitle
    }
    
    func loadChaptersContent() {
        if let id = chapterId {
            let service = AppService()
            Task(priority: .background) {
                let result = await service.getChapter(id: id)
                switch result {
                case .success(let response):
                    print("Capitolul a fost adus cu succes \(response)")
                    chapter = response
                    content.text = response.contentEn
                case .failure(let error):
                    print("Eroare \(error)")
                }
            }
        }
    }
    
}

