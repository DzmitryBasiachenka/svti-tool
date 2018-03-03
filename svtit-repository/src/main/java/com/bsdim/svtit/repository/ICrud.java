package com.bsdim.svtit.repository;

/**
 * The ICrud for work with four base functions.
 * <p>
 * Date: 2018-03-03
 *
 * @author Dzmitry Basiachenka
 *
 * @param <K>
 * @param <E>
 */
public interface ICrud<K, E> {
    /**
     * Creates.
     *
     * @param entity the entity.
     */
    void create(E entity);

    /**
     * Reads.
     *
     * @param key the key.
     * @return the entity.
     */
    E read(K key);

    /**
     * Updates.
     *
     * @param entity the entity.
     */
    void update(E entity);

    /**
     * Deletes.
     *
     * @param key the key.
     */
    void delete(K key);
}
