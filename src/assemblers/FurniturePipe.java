package assemblers;

public class FurniturePipe {
    private ChairInProgress mUnassembledChair;

    public synchronized void setUnassembledChair(ChairInProgress unassembledChair){
        mUnassembledChair = unassembledChair;
    }

    public synchronized void clearPipe(){
        this.mUnassembledChair = null;
    }

    public synchronized ChairInProgress getUnassembledChair(){
        return mUnassembledChair;
    }
}
