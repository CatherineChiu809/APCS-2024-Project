public class coordinate {
    int xcoor;
    int ycoor;
    boolean isMine;
    int num;
    boolean isDark;

    public coordinate(int x, int y){
        xcoor=x;
        ycoor=y;
        isMine=false;
        num=0;
        if((xcoor%2==0&&ycoor%2==0)||(xcoor%2!=0&&ycoor%2!=0)){
            isDark=true;
        }
        else{
            isDark=false;
        }
    }
    //////setter methods
    public void setMine(boolean m){
        isMine=m;
    }
    public void setNum(int n){
        num=n;
    }
    //////getter methods
    public boolean getDark(){
        return isDark;
    }
    public boolean getMine(){
        return isMine;
    }
    public int getX(){
        return xcoor;
    }
    public int getY(){
        return ycoor;
    }
    public int getNum(){
        return num;
    }
    /////other methods
    public void incNum(){
        num=num+1;
    }
}
