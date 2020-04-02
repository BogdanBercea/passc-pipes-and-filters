import assemblers.ChairInProgress;

public interface Pipeline {
    void assembleChair(ChairInProgress chair);

    void putAssemblersToWork();

    boolean isReady();

    void stop();
}
