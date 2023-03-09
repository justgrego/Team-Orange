
public class Task implements Comparable<Task> {
    private String task;
    private String date;

    public Task(String task, String date) {
        this.task = task;
        //format MM/DD/YYYY
        this.date = date;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int compareTo(Task o) {
        String[] thisDate= this.getDate().split("/");
        int thisMonth = Integer.parseInt(thisDate[0]);
        int thisDay = Integer.parseInt(thisDate[1]);
        int thisYear = Integer.parseInt(thisDate[2]);

        String[] otherDate = o.getDate().split("/");
        int otherMonth = Integer.parseInt(otherDate[0]);
        int otherDay = Integer.parseInt(otherDate[1]);
        int otherYear = Integer.parseInt(otherDate[2]);

        int thisTot = (thisYear * 365) + (thisMonth * 30) + thisDay;
        int otherTot = (otherYear * 365) + (otherMonth * 30) + otherDay;

        return otherTot - thisTot;
    }
    public String toString(){
        return this.task + " : " + this.date;
    }

}
