package assemblers;

public class SeatCutter{
    private FurniturePipe mLoadPipe;

    public void setPipe(FurniturePipe pipe) {
        mLoadPipe = pipe;
    }

    public void build(ChairInProgress chair) {
        System.out.println("Cutter: Cutting seat...");
        for (int i = 0; i < 100000; i++) ;

        while(mLoadPipe.getUnassembledChair() != null) {
//            System.out.println("Cutter: waiting to send the seat...");
            // wait until it's empty
        }
            System.out.println("Cutter: Seat sent!");
            mLoadPipe.setUnassembledChair(chair);
//            mLoadPipe = null;
    }

    public boolean isReady() {
        if(mLoadPipe.getUnassembledChair() == null) return true;
        return false;
    }
}

