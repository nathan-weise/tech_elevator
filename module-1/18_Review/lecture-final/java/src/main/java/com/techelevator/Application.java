package com.techelevator;

import com.techelevator.search.SearchDomain;
import com.techelevator.search.SearchDomainException;
import com.techelevator.search.SearchEngine;
import com.techelevator.search.SearchEngineException;
import com.techelevator.util.TELog;
import com.techelevator.view.MenuDrivenCLI;
import com.techelevator.view.BasicUI;

import java.util.List;


public class Application {
	private static final String MENU_OPTION_LIST_INDEXED_FILES = "List files to be searched";
	private static final String MENU_OPTION_PERFORM_SAMPLE_SEARCH = "Do a sample search";
	private static final String MENU_OPTION_QUIT = "Quit";
	private static final String[] MAIN_MENU_OPTIONS = {MENU_OPTION_LIST_INDEXED_FILES,
														MENU_OPTION_PERFORM_SAMPLE_SEARCH,
														MENU_OPTION_QUIT};

	private static final String MENU_OPTION_SAMPLE_SEARCH_1 = "Search for 'squirrel'";
	private static final String MENU_OPTION_SAMPLE_SEARCH_2 = "Search for 'telephone line'";
	private static final String[] SEARCH_MENU_OPTIONS = {MENU_OPTION_SAMPLE_SEARCH_1, MENU_OPTION_SAMPLE_SEARCH_2};

	private SearchDomain searchDomain;
	private SearchEngine searchEngine;

	private final BasicUI ui;

	public Application(BasicUI ui) {
		this.ui = ui;
	}

	public static void main(String[] args) {
		BasicUI cli = new MenuDrivenCLI();
		Application application = new Application(cli);
		application.run();
	}

	public void run() {
		// Step Two: Log the start of the application.
		//
		TELog.log("Search application started");

		prepareDomainAndEngine();

		boolean finished = false;
		while (!finished) {
			String selection = ui.promptForSelection(MAIN_MENU_OPTIONS);
			if (selection.equals(MENU_OPTION_LIST_INDEXED_FILES)) {
				displayIndexedFiles();
			} else if (selection.equals(MENU_OPTION_PERFORM_SAMPLE_SEARCH)) {
				handleSearchMenu();
			} else if (selection.equals(MENU_OPTION_QUIT)) {
				finished = true;
			}
		}
	}

	private void prepareDomainAndEngine() {
		// Step Four: Instantiate a Search Domain
		//
		try {
			searchDomain = new SearchDomain("data");
			TELog.log(searchDomain.toString());

			searchEngine = new SearchEngine(searchDomain);
			searchEngine.indexFiles();
		} catch (SearchDomainException e) {
			ui.output("Couldn't create Search Domain.");
		} catch (SearchEngineException e) {
			ui.output("Search engine couldn't index files.");
		}
	}

	private void displayIndexedFiles() {
		ui.output("The following files will be searched:");
		ui.output(searchDomain.toString());
		ui.pauseOutput();
	}

	private void handleSearchMenu() {
		String selection = ui.promptForSelection(SEARCH_MENU_OPTIONS);
		if (selection.equals(MENU_OPTION_SAMPLE_SEARCH_1)) {
			// Step Six: Single word search
			//
			performSearch("squirrel");
		} else if (selection.equals(MENU_OPTION_SAMPLE_SEARCH_2)) {
			// Step Seven: Multiple word search
			//
			performSearch("telephone line");
		}
	}

	private void performSearch(String searchText) {
		List<String> filenames = searchEngine.search(searchText);
		if (filenames.isEmpty()) {
			ui.output("No results.");
		} else {
			String allFilenames = "";
			for (String filename : filenames) {
				allFilenames += filename + "\n";
			}
			ui.output(allFilenames);
		}
		ui.pauseOutput();
	}
}
