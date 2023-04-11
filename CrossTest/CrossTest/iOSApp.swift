import SwiftUI

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {

		    // ContentView()

            // 	Show get method got content (15/17)
            ContentView(viewModel: ContentView.ViewModel())
		}
	}
}