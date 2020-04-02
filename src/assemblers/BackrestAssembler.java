package assemblers;

public class BackrestAssembler {
    private FurniturePipe mLoadPipe;
    private FurniturePipe mGetPipe;

    public void setLeftPipe(FurniturePipe leftPipe) {
        mGetPipe = leftPipe;
    }

    public void setRightPipe(FurniturePipe rightPipe) {
        mLoadPipe = rightPipe;
    }

    public void build() {
        while (true) {
            if (mGetPipe.getUnassembledChair() == null) {
                //wait until we receive a chair
            }
            if (mGetPipe.getUnassembledChair() != null) {
                System.out.println("Backrest assembler: Assembling backrest...");
                for (int i = 0; i < 150000; i++) ;
                while (mLoadPipe.getUnassembledChair() != null) ; // wait
                mLoadPipe.setUnassembledChair(mGetPipe.getUnassembledChair());
                System.out.println("Backrest assembler: Backrest sent!");
                mGetPipe.clearPipe();
            }
        }
    }
}