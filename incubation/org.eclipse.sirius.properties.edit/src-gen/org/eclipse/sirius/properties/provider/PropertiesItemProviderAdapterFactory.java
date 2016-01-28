/**
 * Copyright (c) 2015 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    Obeo - initial API and implementation
 * 
 */
package org.eclipse.sirius.properties.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.emf.edit.command.CommandParameter;

import org.eclipse.emf.edit.domain.EditingDomain;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IChildCreationExtender;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.sirius.properties.PropertiesFactory;

import org.eclipse.sirius.properties.util.PropertiesAdapterFactory;

import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.Group;

import org.eclipse.sirius.viewpoint.description.util.DescriptionSwitch;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class PropertiesItemProviderAdapterFactory extends PropertiesAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PropertiesItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.ViewExtensionDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ViewExtensionDescriptionItemProvider viewExtensionDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.ViewExtensionDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createViewExtensionDescriptionAdapter() {
        if (viewExtensionDescriptionItemProvider == null) {
            viewExtensionDescriptionItemProvider = new ViewExtensionDescriptionItemProvider(this);
        }

        return viewExtensionDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.PageDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PageDescriptionItemProvider pageDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.PageDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPageDescriptionAdapter() {
        if (pageDescriptionItemProvider == null) {
            pageDescriptionItemProvider = new PageDescriptionItemProvider(this);
        }

        return pageDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.GroupDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected GroupDescriptionItemProvider groupDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.GroupDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createGroupDescriptionAdapter() {
        if (groupDescriptionItemProvider == null) {
            groupDescriptionItemProvider = new GroupDescriptionItemProvider(this);
        }

        return groupDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.ContainerDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ContainerDescriptionItemProvider containerDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.ContainerDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createContainerDescriptionAdapter() {
        if (containerDescriptionItemProvider == null) {
            containerDescriptionItemProvider = new ContainerDescriptionItemProvider(this);
        }

        return containerDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.TextDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected TextDescriptionItemProvider textDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.TextDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createTextDescriptionAdapter() {
        if (textDescriptionItemProvider == null) {
            textDescriptionItemProvider = new TextDescriptionItemProvider(this);
        }

        return textDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.LabelDescription} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected LabelDescriptionItemProvider labelDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.LabelDescription}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createLabelDescriptionAdapter() {
        if (labelDescriptionItemProvider == null) {
            labelDescriptionItemProvider = new LabelDescriptionItemProvider(this);
        }

        return labelDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.DynamicMappingFor} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DynamicMappingForItemProvider dynamicMappingForItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.DynamicMappingFor}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDynamicMappingForAdapter() {
        if (dynamicMappingForItemProvider == null) {
            dynamicMappingForItemProvider = new DynamicMappingForItemProvider(this);
        }

        return dynamicMappingForItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.DynamicMappingSwitch} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DynamicMappingSwitchItemProvider dynamicMappingSwitchItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.DynamicMappingSwitch}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDynamicMappingSwitchAdapter() {
        if (dynamicMappingSwitchItemProvider == null) {
            dynamicMappingSwitchItemProvider = new DynamicMappingSwitchItemProvider(this);
        }

        return dynamicMappingSwitchItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.properties.DynamicMappingCase} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DynamicMappingCaseItemProvider dynamicMappingCaseItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.properties.DynamicMappingCase}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDynamicMappingCaseAdapter() {
        if (dynamicMappingCaseItemProvider == null) {
            dynamicMappingCaseItemProvider = new DynamicMappingCaseItemProvider(this);
        }

        return dynamicMappingCaseItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (viewExtensionDescriptionItemProvider != null) viewExtensionDescriptionItemProvider.dispose();
        if (pageDescriptionItemProvider != null) pageDescriptionItemProvider.dispose();
        if (groupDescriptionItemProvider != null) groupDescriptionItemProvider.dispose();
        if (containerDescriptionItemProvider != null) containerDescriptionItemProvider.dispose();
        if (textDescriptionItemProvider != null) textDescriptionItemProvider.dispose();
        if (labelDescriptionItemProvider != null) labelDescriptionItemProvider.dispose();
        if (dynamicMappingForItemProvider != null) dynamicMappingForItemProvider.dispose();
        if (dynamicMappingSwitchItemProvider != null) dynamicMappingSwitchItemProvider.dispose();
        if (dynamicMappingCaseItemProvider != null) dynamicMappingCaseItemProvider.dispose();
    }

    /**
     * A child creation extender for the {@link DescriptionPackage}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static class DescriptionChildCreationExtender implements IChildCreationExtender {
        /**
         * The switch for creating child descriptors specific to each extended class.
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        protected static class CreationSwitch extends DescriptionSwitch<Object> {
            /**
             * The child descriptors being populated.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected List<Object> newChildDescriptors;

            /**
             * The domain in which to create the children.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected EditingDomain editingDomain;

            /**
             * Creates the a switch for populating child descriptors in the given domain.
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            CreationSwitch(List<Object> newChildDescriptors, EditingDomain editingDomain) {
                this.newChildDescriptors = newChildDescriptors;
                this.editingDomain = editingDomain;
            }
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            @Override
            public Object caseGroup(Group object) {
                newChildDescriptors.add
                    (createChildParameter
                        (DescriptionPackage.Literals.GROUP__EXTENSIONS,
                         PropertiesFactory.eINSTANCE.createViewExtensionDescription()));

                return null;
            }
 
            /**
             * <!-- begin-user-doc -->
             * <!-- end-user-doc -->
             * @generated
             */
            protected CommandParameter createChildParameter(Object feature, Object child) {
                return new CommandParameter(null, feature, child);
            }

        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public Collection<Object> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
            ArrayList<Object> result = new ArrayList<Object>();
            new CreationSwitch(result, editingDomain).doSwitch((EObject)object);
            return result;
        }

        /**
         * <!-- begin-user-doc -->
         * <!-- end-user-doc -->
         * @generated
         */
        public ResourceLocator getResourceLocator() {
            return PropertiesEditPlugin.INSTANCE;
        }
    }

}
