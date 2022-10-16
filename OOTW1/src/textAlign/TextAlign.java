package textAlign;

public class TextAlign {
    private final AlignMeth alignMeth;

    TextAlign(AlignMeth a){
        this.alignMeth = a;
    }
    public void align(){
        alignMeth.align();
    }
}
