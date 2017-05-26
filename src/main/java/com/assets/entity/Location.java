package com.assets.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2017/5/17 0017.
 */
/*资产存放位置*/
@Entity
public class Location implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String locationName; //地点名称
    private String detailedAddress; //详细地址
    private String locationLevel; //地址级别

    /**
     * 上级分类
     */
    @ManyToOne(optional = true)
    private Location  locationParent;
    /**
     * 下级分类
     */
    @OneToMany(cascade={CascadeType.REFRESH,CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REMOVE}
            ,fetch = FetchType.LAZY,mappedBy = "locationParent")

    private Set<Location> locations=new HashSet();


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }


    public String getLocationLevel() {
        return locationLevel;
    }

    public void setLocationLevel(String locationLevel) {
        this.locationLevel = locationLevel;
    }

    public Location getLocationParent() {
        return locationParent;
    }

    public void setLocationParent(Location locationParent) {
        this.locationParent = locationParent;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }
}
//地点名称，说明，地点地址，建筑物，房间号，楼层，地点编码，经理，维护，父级地点
