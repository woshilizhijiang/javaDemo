//package com.zk.curator.demo01;
//
//import org.I0Itec.zkclient.IZkConnection;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.api.BackgroundCallback;
//import org.apache.curator.framework.api.CuratorEvent;
//import org.apache.curator.framework.api.CuratorListener;
//import org.apache.zookeeper.*;
//import org.apache.zookeeper.data.ACL;
//import org.apache.zookeeper.data.Stat;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicReference;
//
//public class CuratorZKClientBridge  implements IZkConnection{
//
//    private final CuratorFramework curator;
//    private final AtomicReference<CuratorListener> listener = new AtomicReference<CuratorListener>(null);
//
//    public CuratorFramework getCurator() {
//        return curator;
//    }
//
//    public CuratorZKClientBridge(CuratorFramework curator){
//        this.curator = curator;
//    }
//
//    @Override
//    public void connect(Watcher watcher) {
//        if (null != watcher){
//            CuratorListener localListener = new CuratorListener() {
//                @Override
//                public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
//                    if (null != event.getWatchedEvent()){
//                        watcher.process(event.getWatchedEvent());
//                    }
//                }
//            };
//
//            curator.getCuratorListenable().addListener(localListener);
//            listener.set(localListener);
//
//            try{
//                BackgroundCallback callback = new BackgroundCallback() {
//                    @Override
//                    public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
//                        WatchedEvent fakeEvent = new WatchedEvent(Watcher.Event.EventType.None,
//                                curator.getZookeeperClient().isConnected()
//                                        ? Watcher.Event.KeeperState.SyncConnected : Watcher.Event.KeeperState.Disconnected,null);
//                        watcher.process(fakeEvent);
//                    }
//                };
//
//                curator.checkExists().inBackground(callback).forPath("/foo");
//
//            }catch (Exception e){
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    @Override
//    public void close() throws InterruptedException {
//        CuratorListener localListerner = listener.getAndSet(null);
//        if (null != localListerner){
//            curator.getCuratorListenable().removeListener(localListerner);
//        }
//    }
//
//    @Override
//    public String create(String path, byte[] data, CreateMode mode) throws KeeperException, InterruptedException {
//        try {
//            return curator.create().withMode(mode).forPath(path, data);
//        }catch (Exception e){
//            adjustException(e);
//        }
//        return null;
//    }
//
//
//    @Override
//    public void delete(String path) throws InterruptedException, KeeperException {
//        try {
//            curator.delete().forPath(path);
//        }catch (Exception e){
//            adjustException(e);
//        }
//    }
//
//    @Override
//    public boolean exists(String path, boolean watch) throws KeeperException, InterruptedException {
//        try {
//            return watch ? ((curator.checkExists().watched().forPath(path)) != null) :(curator.checkExists().forPath(path) != null);
//        }catch (Exception e){
//            adjustException(e);
//        }
//        return false;
//    }
//
//    @Override
//    public List<String> getChildren(String path, boolean watch) throws KeeperException, InterruptedException {
//        try
//        {
//            return watch ? curator.getChildren().watched().forPath(path) : curator.getChildren().forPath(path);
//        }
//        catch ( Exception e )
//        {
//            adjustException(e);
//        }
//        return null;
//    }
//
//    @Override
//    public byte[] readData(String path, Stat stat, boolean watch) throws KeeperException, InterruptedException {
//        try
//        {
//            if ( stat != null )
//            {
//                return watch ? curator.getData().storingStatIn(stat).watched().forPath(path) : curator.getData().storingStatIn(stat).forPath(path);
//            }
//            else
//            {
//                return watch ? curator.getData().watched().forPath(path) : curator.getData().forPath(path);
//            }
//        }
//        catch ( Exception e )
//        {
//            adjustException(e);
//        }
//        return null;   // will never execute
//    }
//
//    @Override
//    public void writeData(String path, byte[] data, int expectedVersion) throws KeeperException, InterruptedException {
//        writeDataReturnStat(path, data, expectedVersion);
//    }
//
//    @Override
//    public Stat writeDataReturnStat(String path, byte[] data, int expectedVersion) throws KeeperException, InterruptedException {
//        try
//        {
//            curator.setData().withVersion(expectedVersion).forPath(path, data);
//        }
//        catch ( Exception e )
//        {
//            adjustException(e);
//        }
//        return null; // will never execute
//    }
//
//    @Override
//    public ZooKeeper.States getZookeeperState() {
//        try
//        {
//            return curator.getZookeeperClient().getZooKeeper().getState();
//        }
//        catch ( Exception e )
//        {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public long getCreateTime(String path) throws KeeperException, InterruptedException {
//        try
//        {
//            Stat            stat = curator.checkExists().forPath(path);
//            return (stat != null) ? stat.getCtime() : 0;
//        }
//        catch ( Exception e )
//        {
//            adjustException(e);
//        }
//        return 0;
//    }
//
//    @Override
//    public String getServers() {
//        return curator.getZookeeperClient().getCurrentConnectionString();
//    }
//
//
//
//    private void adjustException(Exception e) throws KeeperException, InterruptedException{
//        if ( e instanceof KeeperException )
//        {
//            throw (KeeperException)e;
//        }
//
//        if ( e instanceof InterruptedException )
//        {
//            throw (InterruptedException)e;
//        }
//
//        throw new RuntimeException(e);
//    }
//
//
//    @Override
//    public String create(String s, byte[] bytes, List<ACL> list, CreateMode createMode) throws KeeperException, InterruptedException {
//        return null;
//    }
//    @Override
//    public void delete(String s, int i) throws InterruptedException, KeeperException {
//
//    }
//
//    @Override
//    public List<OpResult> multi(Iterable<Op> iterable) throws KeeperException, InterruptedException {
//        return null;
//    }
//
//    @Override
//    public void addAuthInfo(String s, byte[] bytes) {
//
//    }
//
//    @Override
//    public void setAcl(String s, List<ACL> list, int i) throws KeeperException, InterruptedException {
//
//    }
//
//    @Override
//    public Map.Entry<List<ACL>, Stat> getAcl(String s) throws KeeperException, InterruptedException {
//        return null;
//    }
//}
