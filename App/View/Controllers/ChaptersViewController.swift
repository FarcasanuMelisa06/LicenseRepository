//
//  ChaptersController.swift
//  TestProject
//
//  Created by Melisa Farcasanu on 18.03.2023.
//

import Foundation
import UIKit

class ChaptersViewController: UIViewController {
    
    @IBOutlet weak var collectionView: UICollectionView!
    var chapters: [Chapter] = []
//
    override func viewDidLoad() {
        super.viewDidLoad()
        loadChapters()
    }
    
    func loadChapters() {
        let service = AppService()
        Task(priority: .background) {
            let result = await service.getChapters()
            switch result {
            case .success(let response):
                print("Capitolele au fost aduse cu succes \(response)")
                chapters = response
                collectionView.reloadData()
            case .failure(let error):
                print("Eroare \(error)")
            }
        }
    }
}

extension ChaptersViewController: UICollectionViewDelegate, UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return chapters.count
    }
    
    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        if let cell  = collectionView.dequeueReusableCell(withReuseIdentifier: "ChapterCell", for: indexPath) as? ChapterCell {
            cell.configure(title: chapters[indexPath.row].name, image: chapters[indexPath.row].image)
            return cell
        }
        return UICollectionViewCell()
    }
}

extension ChaptersViewController: UICollectionViewDelegateFlowLayout {
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
        return CGSize(width: UIScreen.main.bounds.width - 40, height: UIScreen.main.bounds.height / 2)
    }
}

extension ChaptersViewController: UIScrollViewDelegate {
    func scrollViewDidEndDecelerating(_ scrollView: UIScrollView) {
        self.collectionView.scrollToNearestVisibleCollectionViewCell()
    }

    func scrollViewDidEndDragging(_ scrollView: UIScrollView, willDecelerate decelerate: Bool) {
        if !decelerate {
            self.collectionView.scrollToNearestVisibleCollectionViewCell()
        }
    }
}
