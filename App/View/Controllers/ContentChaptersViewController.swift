//
//  ContentChaptersViewController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 25.03.2023.
//

import Foundation
import UIKit
import AVFoundation

class ContentChaptersViewController: UIViewController, ManagerInjector{
    
    @IBOutlet weak var chapterName: UILabel!
    @IBOutlet weak var content: UILabel!
 
    @IBOutlet var audioButton: UIBarButtonItem!
    
    var contentAudio: String!
    let playIcon = UIImage(named: "play.png")
    let pauseIcon = UIImage(named: "pauseIcon.png")
    let synth = AVSpeechSynthesizer()
    
    @IBAction func search(_ sender: Any) {
        performSegue(withIdentifier: "goToSeachSeque", sender: nil)
    }
    
    
    @IBAction func audio(_ sender: Any) {
        
        let utterance = AVSpeechUtterance(string: contentAudio)
       
       // when synth is already speaking or is in paused state
        if synth.isSpeaking {
           
            //audioButton.setBackgroundImage(playIcon, for: .normal, barMetrics: .default)
            if synth.isPaused {
                
                audioButton.setBackgroundImage(pauseIcon, for: .normal, barMetrics: .default)
                synth.continueSpeaking()
                
            }else {
                
                audioButton.setBackgroundImage(playIcon, for: .normal, barMetrics: .default)
                synth.pauseSpeaking(at: AVSpeechBoundary.immediate)
            }
        }else {
            // when synth is not started yet
            if manager.language == AppLanguage.english.rawValue {
                
                utterance.voice = AVSpeechSynthesisVoice(language: "en-US")
                synth.speak(utterance)
                audioButton.setBackgroundImage(pauseIcon, for: .normal, barMetrics: .default)
                
            }else {
                utterance.voice = AVSpeechSynthesisVoice(language: "ro-US")
                synth.speak(utterance)
                audioButton.setBackgroundImage(pauseIcon, for: .normal, barMetrics: .default)
            }
        }
    }
    
    
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
        audioButton.setBackgroundImage(playIcon, for: .normal, barMetrics: .default)
        
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
                    content.text = response.content
                    contentAudio = response.content
                case .failure(let error):
                    print("Eroare \(error)")
                }
            }
        }
    }
    
}

