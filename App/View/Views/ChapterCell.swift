//
//  ChapterCell.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 18.03.2023.
//

import Foundation
import UIKit
import SDWebImage

class ChapterCell: UITableViewCell {

    @IBOutlet weak var initialdescription: UILabel!
    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var chapterImage: UIImageView!
    
    func configure(title: String, image: String, initialdescription: String) {
        self.title.text = title
        self.initialdescription.text = initialdescription
        if let imageURL = URL(string: image) {
            self.chapterImage.sd_setImage(with: imageURL)
        }
       
        chapterImage.layer.borderWidth = 1
        chapterImage.clipsToBounds = true
        chapterImage.layer.cornerRadius = 20
        
    }
}

