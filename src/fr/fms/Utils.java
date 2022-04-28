package fr.fms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.github.freva.asciitable.AsciiTable;
import com.github.freva.asciitable.Column;
import com.github.freva.asciitable.HorizontalAlign;

import fr.fms.entities.Book;
import fr.fms.entities.Theme;

public class Utils {
	
	public static void formatDataBook(List<Book> books) {
		System.out.println();
		Character[] borderStyle = AsciiTable.FANCY_ASCII;
		System.out.println(AsciiTable.getTable(borderStyle, books, Arrays.asList(
				new Column().header("ID").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> String.format("%.02s", book.getId())),
				new Column().header("Titre").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> book.getTitle()),
				new Column().header("Description").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> book.getDescription()),
				new Column().header("Autheur").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> book.getAuthor()),
				new Column().header("Prix").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> book.getPrice() + "�"),
				new Column().header("Etat").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(book -> book.isUsedBook() ? "Occasion" : "Neuf")
		)));
		System.out.println();
	}
	
	public static void formatDataCart(HashMap<Integer, Book> cart) {
		System.out.println();
		Character[] borderStyle = AsciiTable.FANCY_ASCII;
		System.out.println(AsciiTable.getTable(borderStyle, cart.entrySet(), Arrays.asList(
				new Column().header("ID").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> String.format("%.02s", e.getKey())),
				new Column().header("Titre").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> e.getValue().getTitle()),
				new Column().header("Autheur").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> e.getValue().getAuthor()),
				new Column().header("Prix")
					.headerAlign(HorizontalAlign.CENTER)
					.dataAlign(HorizontalAlign.CENTER)
					.with(e -> String.format("%.02s", e.getValue().getPrice())),
				new Column().header("Quantité").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> String.format("%.02s", e.getValue().getQuantity()))
				
		)));
		System.out.println();
	}
	
	public static void formatDataTheme(List<Theme> themes) {
		System.out.println();
		Character[] borderStyle = AsciiTable.FANCY_ASCII;
		System.out.println(AsciiTable.getTable(borderStyle, themes, Arrays.asList(
				new Column().header("ID").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> String.format("%.02s", e.getId())),
				new Column().header("Titre").headerAlign(HorizontalAlign.CENTER).dataAlign(HorizontalAlign.CENTER).with(e -> e.getName())
		)));
		System.out.println();
	}

}
