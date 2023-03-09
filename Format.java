package HWs.HW4.MyPlanner;

public interface Format {
    <T extends Task> String createString(T task);
}
