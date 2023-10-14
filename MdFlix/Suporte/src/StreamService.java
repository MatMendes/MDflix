public class StreamService {
    private boolean isStreaming;

    public StreamService() {
        this.isStreaming = false;
    }

    public boolean iniciarStreaming() {
        if (!isStreaming) {
            isStreaming = true;
            return true;
        }
        return false;
    }

    public boolean pararStreaming() {
        if (isStreaming) {
            isStreaming = false;
            return true;
        }
        return false;
    }

    public boolean estaStreaming() {
        return isStreaming;
    }
}
