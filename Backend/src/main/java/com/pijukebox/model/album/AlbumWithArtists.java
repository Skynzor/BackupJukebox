package com.pijukebox.model.album;

import com.pijukebox.model.BaseModel;
import com.pijukebox.model.simple.SimpleArtist;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "album")
public class AlbumWithArtists extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "releaseDate")
    private String releaseDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "artist_album", catalog = "pijukebox", joinColumns = {@JoinColumn(name = "album_id", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "artist_id", nullable = false)})
    private Set<SimpleArtist> artists = new HashSet<>();
}