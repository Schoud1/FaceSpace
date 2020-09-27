# FaceSpace


A social network, in the simplest sense, is a means of keeping track of a set of people (each of whom have a "profile") and the relationships (usually involving friendship) between them. A common way to represent this network is using a graph. Each node in the graph represents a user profile, and an edge connects two users if they are friends.


Create a social network application called FaceSpace. Your application should support the following operations:

Add/update a User: Adds/updates a user profile with a given name to the network. All user profiles should be uniquely identified by their names. Your program should not allow a user profile to be added if the given name already exists in the network.

Search for a User: Retrieves the user profile with a given name and displays all its information including the name, a list of the user's friends, and other optional information (such as current status and profile pictures). You need to use an appropriate data structure to support efficient searching, inserting, and deleting.

Add a Friend for a User: Adds a profile with a given name to the list of friends of the given user. We assume all the friendships are reciprocal. In other words, if Bob adds Alice into his list of friends, Bob will also be added into Alice's list of friends. Moreover, only users present in the network can be added as friends.

Remove a Friend for a User: Removes a profile with a given name from the list of friends of the given user. This should also be reciprocal.

Find Shortest Path between two users (degree of separation): Computes the shortest path (the minimum number of "hops") between two given users. Note that the underlying graph should be unweighted so the shortest path is simply the path with the minimum number of edges between the two nodes and can be computed using a breadth-first search algorithm. Note that there may be cases where two users are not connected at all.
