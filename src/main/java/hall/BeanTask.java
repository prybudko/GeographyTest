package hall;

import java.util.List;

public class BeanTask {

    List<Task> beanTask = null;

    public List<Task> getBeanTask() {
        return beanTask;
    }

    public void setBeanTask() {
        InitialTask initialTask = new InitialTask();
        List<Task> taskList = initialTask.getTask();
        beanTask = taskList;
    }
}

