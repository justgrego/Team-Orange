import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


/**
 * author: JD Sawyer
 */
public class Project {
    private LinkedList<Task> ToDoList = new LinkedList<>();
    private LinkedList<String> materials = new LinkedList<>();
    private LinkedList<Receipt> receipts = new LinkedList<>();
    private LinkedList<Plan> plans = new LinkedList<Plan>();

    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }

    public void addPlan(Plan plan){
        plans.add(plan);
    }

    public void addMaterials(String mats){
        materials.add(mats);
    }

    public void addTask(Task task){
        ToDoList.add(task);
        Collections.sort(ToDoList, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.reverse(ToDoList);
    }

    public String printList(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < ToDoList.size() ; i++){
            str.append(ToDoList.get(i).toString() + "\n");
        }
        return str.toString();
    }
}
