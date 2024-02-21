public class Pair<K, V> {
    private K k;
    private V v;

    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }

    public K getFirst(){
        return k;
    }
    public V getSecond(){
        return v;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pair{");
        sb.append("k=").append(k);
        sb.append(", v=").append(v);
        sb.append('}');
        return sb.toString();
    }
}
