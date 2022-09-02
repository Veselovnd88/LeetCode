package treebuilding;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomTree extends AbstractList<String>  implements Serializable,Cloneable {
    private Entry root;
    public List<Entry> tree = new ArrayList<>();

    public CustomTree(){
        this.root = new Entry("Root");//создали корень
        tree.add(root);//добавили корень
    }

    public String getParent(String name){
        for(Entry e:tree){
            if(e.elementName!=null){
                if(e.elementName.equals(name)){
                    return e.parent.elementName;
                }
            }
        } return null;
    }
    @Override
    public boolean add(String name){
        /*Если можно добавить слева - то создаем новый ентри, и добавляем как левого потомка
        * делаем возможность добавки на фолс, добавляем в список*/
        for (Entry e: tree){
            if(e.isAvailableToAdd()){
                if(e.isAvailableToAddLeft){
                    e.left = new Entry(name);//
                    e.isAvailableToAddLeft=false;
                    tree.add(e.left);
                    e.left.parent=e;
                    return true;
                } else if (e.isAvailableToAddRight) {
                    e.right = new Entry(name);
                    e.isAvailableToAddRight=false;
                    tree.add(e.right);
                    e.right.parent=e;
                    return true;
                }}
        }
        return false;

}

    /*На вход подается ентри которую нужно удалить, если у нее нет потомков - то просто удаляется из списка
    * если есть потомки - то к каждой применяется та же функция */
    private boolean removeChild(Entry entry){
        if(entry==null){
            return false;
        }
        if(entry.left==null&& entry.right==null){
            tree.remove(entry);
            return true;
        }
        else{
            removeChild(entry.left);
            removeChild(entry.right);
            tree.remove(entry);
            return true;
        }
    }

    @Override
    public boolean remove(Object o){
            if(o instanceof String){
                for(Entry e: tree){
                    if(o.equals(e.elementName)){
                            if(e.parent!=null){
                                if(e.parent.left==e){
                                    e.parent.isAvailableToAddLeft=true;
                                }
                                else{
                                    e.parent.isAvailableToAddRight=true;
                                }
                            }
                            return removeChild(e);
                    }
                }return false;

            }
            else{
                throw  new UnsupportedOperationException();
            }
    }




    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }



    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size();
    }



    private static class Entry<K> implements Serializable{
        String elementName;
        boolean isAvailableToAddLeft;
        boolean isAvailableToAddRight;
        Entry<K> parent;
        Entry<K> left;
        Entry<K> right;

        public Entry(String name){
            this.elementName = name;
            this.isAvailableToAddLeft=true;
            this.isAvailableToAddRight=true;
        }

        public boolean isAvailableToAdd(){
            return isAvailableToAddLeft||isAvailableToAddRight;
        }

        @Override
        public String toString(){
            return this.elementName;
        }
    }
}
