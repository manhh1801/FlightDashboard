package project.app.BackgroundFrame.MainFrame.ContentPane.PaneState;

public class PaneState
{
    public static class Wrapper
    {
        State State_var;
        public void set(State State_args) {State_var=State_args;}
        public State get() {return State_var;}
    }
    public enum State {HOME, SCHEDULES, TICKETS, STATISTICS, CONTACTS, SETTINGS}
}
