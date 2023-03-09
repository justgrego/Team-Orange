import javax.swing.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;


/**
 * author: JD Sawyer
 */
public class Project {
    private LinkedList<Task> toDoList;
    private LinkedList<String> materials;
    private LinkedList<Receipt> receipts;
    private LinkedList<Plan> plans;

    public void addReceipt(Receipt receipt){
        receipts.add(receipt);
    }

    public void addPlan(Plan plan){
        plans.add(plan);
    }

    public void addMaterials(String mats){
        materials.add(mats);
    }

    Project(){
        this.toDoList  = new LinkedList<>();
        this.materials  = new LinkedList<>();
        this.receipts  = new LinkedList<>();
        this.plans  = new LinkedList<>();
    }

    public void deleteTask(String taskText){
        // !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    public void addTask(Task task){
        toDoList.add(task);
        if(toDoList.size() > 1) {
            Collections.sort(toDoList, new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    return o1.compareTo(o2);
                }
            });
            Collections.reverse(toDoList);
        }
    }

    public void rePopulateTasks(){
        if(!toDoList.isEmpty())
            for(int n = 0; n < toDoList.size(); n++){
                    toDoList.get(n).getTextArea().setText(toDoList.get(n).getTask());
                    toDoList.get(n).getPanel().setVisible(true);
        }
    }

    public String printList(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < toDoList.size() ; i++){
            str.append(toDoList.get(i).toString() + "\n");
        }
        return str.toString();
    }
}
