//
//  CourseCell.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 16.03.2023.
//

import Foundation
import UIKit

class CourseCell: UITableViewCell {
    
    @IBOutlet weak var title: UILabel!
    
    func configure(title: String) {
        self.title.text = title
    }
}
