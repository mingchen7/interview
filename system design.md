# Concepts and Knowledge

## Database

* SQL database: 1K
* NoSQL database: 10K
* Redis (cache-through): 100K, 支持数据持久化
* Memcached (cache-aside): 1M ，不支持数据持久化

NoSQL数据结构：row key(hash key), column key(可以range query), value

## Sharding
Vertical: 根据table或者table中的column来sharding  
Horizontal: 根据id hash value来sharding

**Consistent Hashing**   
http://www.lintcode.com/problem/consistent-hashing/
https://www.lintcode.com/problem/consistent-hashing-ii/
http://michaelnielsen.org/blog/consistent-hashing/
https://blog.csdn.net/sparkliang/article/details/5279393


## replica
Master/Slave: master做read & write, slave read only.  
how to replicate: write ahead log.  

ACID: atomicity, consistency, isolation, and durability


## CAP Theorem
Consistency, Availability, and Partition tolerance

![alt text](https://www.researchgate.net/profile/Hamzeh_Khazaei/publication/282679529/figure/fig2/AS:614316814372880@1523475950595/Visualization-of-CAP-theorem.png "CAP theorem")  

## Networking

**Ajax Polling**: the client repeatedly polls (or requests) a server for data.  
**HTTP long-polling**: server可以不及时回复，直到数据available之后才返回。  
**WebSocket**: client和server建立双向通道来回交换数据。  
**Server-sent Events**: 只能由server不停地向client发送数据。persistent & long-term。    



# Design Considerations
## Pull vs Push
**Pull model**
* news feed - 获取每个好友前100条feed + k路合并 (N次DB读取操作)  
* post feed - 1次DB写操作。  
* 缺点 - N次DB读取非常慢，且block了用户请求。

**Push model**
* 单独为用户建一个list存乎news feed。用户发一个推文，将news推送到news feed list中 - *fan out*。  
* news feed为1次DB读取， post a tweet则需要N次DB写入，可以asynchronous。  
* 缺陷 - 遇到明星用户需要写入的用户太多。  

Pull模型瓶颈在于read，用cache可以有效解决。Push模型可以结合Pull来trade off。  
热点问题(thundering herd) - 因为是请求同一条tweet，任何sharding和cache都无解。
