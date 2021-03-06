//
//  DinosaurView.swift
//  Dinosaurs
//
//  Created by Egor Andreevici on 2019-12-23.
//  Copyright © 2019 Square. All rights reserved.
//

import SwiftUI
import protos

struct DinosaurView: View {
  var body: some View {
    VStack(alignment: .leading) {
      Text("Name: \(dinosaur.name)")
        .font(.title)
        .padding()
      Text("Period: \(dinosaur.period.description())")
        .font(.body)
        .padding()
      Text("Length: \(dinosaur.length_meters.description)")
        .font(.body)
        .padding()
      Text("Mass: \(dinosaur.mass_kilograms.description)")
        .font(.body)
        .padding()
      Text("Image url: \(dinosaur.picture_urls[0])")
        .font(.body)
        .padding()
    }
  }
  
  var dinosaur: Dinosaur
}

struct DinosaurView_Previews: PreviewProvider {
  static var previews: some View {
    return DinosaurView(dinosaur: buildDinosaur())
  }
  
  static func buildDinosaur() -> Dinosaur {
    let encodedDino = "CgtTdGVnb3NhdXJ1cxIUaHR0cDovL2dvby5nbC9MRDVLWTUSFGh0dHA6Ly9nb28uZ2wvVllSTTY3GQAAAAAAACJAIQAAAAAAiLNAKAI="
    let data = NSData(base64Encoded: encodedDino, options: .ignoreUnknownCharacters)!
    return Dinosaur.Companion.init().ADAPTER.decode(data: data as Data) as! Dinosaur
  }
}

