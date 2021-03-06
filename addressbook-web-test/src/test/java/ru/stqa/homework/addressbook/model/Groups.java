package ru.stqa.homework.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;
import java.util.Collection;
import java.util.List;

/**
 * Created by Yulia on 20.03.2016.
 */
public class Groups extends ForwardingSet<GroupData> {

  private Set<GroupData> delegate;

  public Groups (Groups groups){
    this.delegate = new HashSet<>(groups.delegate);
  }

  @Override
  protected Set<GroupData> delegate() {
    return delegate;
  }

  public Groups withAdded(GroupData group){
    Groups groups = new Groups(this);
    groups.add(group);
    return groups;
  }

  public Groups without(GroupData group){
    Groups groups = new Groups(this);
    groups.remove(group);
    return groups;
  }

  public Groups(){
    this.delegate = new HashSet<>();
  }

  public Groups(Collection<GroupData> groups) {
           this.delegate = new HashSet<GroupData>(groups);
       }


}
