import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.EmployeeHelper;
import controller.ListDetailsHelper;
import model.Employee;
import model.ListDetails;
import model.ListItems;

public class EmployeeTester {

	public static void main(String[] args) {
		Employee mark = new Employee("Mark");
		ListDetailsHelper ldh = new ListDetailsHelper();
		ListItems mower = new ListItems("Rider", "Red");
		ListItems yard = new ListItems("Susan", "Ames");
		List<ListItems> markItems = new ArrayList<ListItems>();
		markItems.add(mower);
		markItems.add(yard);
		ListDetails markList = new ListDetails("Mark's Mowing List", LocalDate.now(), mark);

		markList.setListOfItems(markItems);
		ldh.insertNewListDetails(markList);
		List<ListDetails> allLists = ldh.getLists();
		for (ListDetails a : allLists) {
			System.out.println(a.toString());
		}
	}
}
