package assemblers;

public class FeetAssembler {
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
                //wait
            }
            else {
                System.out.println("Feet assembler: Assembling feet...");
                for (int i = 0; i < 400000; i++) ;
                while(mLoadPipe.getUnassembledChair() != null); //wait
                mLoadPipe.setUnassembledChair(mGetPipe.getUnassembledChair());
                System.out.println("Feet assembler: chair with feet sent!");
                mGetPipe.clearPipe();
//                mGetPipe = null;
//                mLoadPipe = null;
            }
        }
    }
}
