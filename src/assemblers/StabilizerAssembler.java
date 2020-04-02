package assemblers;

public class StabilizerAssembler{
    private FurniturePipe mGetPipe;
    private FurniturePipe mLoadPipe;

    public void setLeftPipe(FurniturePipe leftPipe) {
        mGetPipe = leftPipe;
    }

    public void setRightPipe(FurniturePipe rightPipe) {
        mLoadPipe = rightPipe;
    }

//    @Override
//    public void run() {
//        try{
//            this.build();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }

    public void build() {
        while(true) {
            if (mGetPipe.getUnassembledChair() == null) {
                // wait
            }
            else {
                System.out.println("Stabilizer assembler: Putting stabilizer bar...");
                for (int i = 0; i < 200000; i++) ;
                while(mLoadPipe.getUnassembledChair() != null);//wait
                mLoadPipe.setUnassembledChair(mGetPipe.getUnassembledChair());
                System.out.println("Stabilizer assembler: chair with stabilizer sent!");
                mGetPipe.setUnassembledChair(null);
//                mGetPipe = null;
//                mLoadPipe = null;
            }
        }
    }
}
