//
//  ContentChapterCell.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 28.03.2023.
//

import Foundation
import UIKit

class ContentChapterCell: UITableViewCell {
    


    @IBOutlet weak var title: UILabel!
    @IBOutlet weak var contentRo: UILabel!
    
    func configure(title: String, contentRo: String) {
        self.title.text = title
        self.contentRo.text = contentRo
    }
    
}
