package repository;

import domain.UserLocation;

public interface UserLocationDao {
    UserLocation findByUserId(int user_id);
    
    void insert(UserLocation location);
    void update(UserLocation location);
}