package Iterator;

import Database.Model.DocumentModel;

import java.util.List;

public class ConcreteVersionIterator implements VersionIterator{
    private List<DocumentModel> versionList;
    private int iteratorIndex = 0;

    public ConcreteVersionIterator(List<DocumentModel> versionList) {
        this.versionList=versionList;
    }

    @Override
    public boolean hasNext() {
        if(this.versionList.size()>this.iteratorIndex){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public DocumentModel getNext() {
        DocumentModel documentModel = this.versionList.get(iteratorIndex);
        this.iteratorIndex++;
        return documentModel;
    }


}
