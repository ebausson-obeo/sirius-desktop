/**
 * Copyright (c) 2007, 2013 THALES GLOBAL SERVICES.
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *
 */
package org.eclipse.sirius.viewpoint.description.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ChildCreationExtenderManager;
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
import org.eclipse.sirius.viewpoint.description.DescriptionPackage;
import org.eclipse.sirius.viewpoint.description.util.DescriptionAdapterFactory;
import org.eclipse.sirius.viewpoint.provider.SiriusEditPlugin;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers. The adapters generated by this
 * factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}. The adapters
 * also support Eclipse property sheets. Note that most of the adapters are shared among multiple instances. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class DescriptionItemProviderAdapterFactory extends DescriptionAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable, IChildCreationExtender {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This helps manage the child creation extenders. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ChildCreationExtenderManager childCreationExtenderManager = new ChildCreationExtenderManager(SiriusEditPlugin.INSTANCE, DescriptionPackage.eNS_URI);

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<>();

    /**
     * This constructs an instance. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public DescriptionItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.Group}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected GroupItemProvider groupItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.Group}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createGroupAdapter() {
        if (groupItemProvider == null) {
            groupItemProvider = new GroupItemProvider(this);
        }

        return groupItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.Viewpoint}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ViewpointItemProvider viewpointItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.Viewpoint}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createViewpointAdapter() {
        if (viewpointItemProvider == null) {
            viewpointItemProvider = new ViewpointItemProvider(this);
        }

        return viewpointItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.MetamodelExtensionSetting} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected MetamodelExtensionSettingItemProvider metamodelExtensionSettingItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.MetamodelExtensionSetting}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createMetamodelExtensionSettingAdapter() {
        if (metamodelExtensionSettingItemProvider == null) {
            metamodelExtensionSettingItemProvider = new MetamodelExtensionSettingItemProvider(this);
        }

        return metamodelExtensionSettingItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.JavaExtension}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected JavaExtensionItemProvider javaExtensionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.JavaExtension}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createJavaExtensionAdapter() {
        if (javaExtensionItemProvider == null) {
            javaExtensionItemProvider = new JavaExtensionItemProvider(this);
        }

        return javaExtensionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.DAnnotation}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected DAnnotationItemProvider dAnnotationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.DAnnotation}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createDAnnotationAdapter() {
        if (dAnnotationItemProvider == null) {
            dAnnotationItemProvider = new DAnnotationItemProvider(this);
        }

        return dAnnotationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.DecorationDescriptionsSet} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected DecorationDescriptionsSetItemProvider decorationDescriptionsSetItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.DecorationDescriptionsSet}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createDecorationDescriptionsSetAdapter() {
        if (decorationDescriptionsSetItemProvider == null) {
            decorationDescriptionsSetItemProvider = new DecorationDescriptionsSetItemProvider(this);
        }

        return decorationDescriptionsSetItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.SemanticBasedDecoration} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected SemanticBasedDecorationItemProvider semanticBasedDecorationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.SemanticBasedDecoration}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSemanticBasedDecorationAdapter() {
        if (semanticBasedDecorationItemProvider == null) {
            semanticBasedDecorationItemProvider = new SemanticBasedDecorationItemProvider(this);
        }

        return semanticBasedDecorationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.GenericDecorationDescription} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected GenericDecorationDescriptionItemProvider genericDecorationDescriptionItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.GenericDecorationDescription}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createGenericDecorationDescriptionAdapter() {
        if (genericDecorationDescriptionItemProvider == null) {
            genericDecorationDescriptionItemProvider = new GenericDecorationDescriptionItemProvider(this);
        }

        return genericDecorationDescriptionItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.Customization}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected CustomizationItemProvider customizationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.Customization}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createCustomizationAdapter() {
        if (customizationItemProvider == null) {
            customizationItemProvider = new CustomizationItemProvider(this);
        }

        return customizationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.VSMElementCustomization} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected VSMElementCustomizationItemProvider vsmElementCustomizationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.VSMElementCustomization}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createVSMElementCustomizationAdapter() {
        if (vsmElementCustomizationItemProvider == null) {
            vsmElementCustomizationItemProvider = new VSMElementCustomizationItemProvider(this);
        }

        return vsmElementCustomizationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.VSMElementCustomizationReuse} instances. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    protected VSMElementCustomizationReuseItemProvider vsmElementCustomizationReuseItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.VSMElementCustomizationReuse}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createVSMElementCustomizationReuseAdapter() {
        if (vsmElementCustomizationReuseItemProvider == null) {
            vsmElementCustomizationReuseItemProvider = new VSMElementCustomizationReuseItemProvider(this);
        }

        return vsmElementCustomizationReuseItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.EAttributeCustomization} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected EAttributeCustomizationItemProvider eAttributeCustomizationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.EAttributeCustomization}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createEAttributeCustomizationAdapter() {
        if (eAttributeCustomizationItemProvider == null) {
            eAttributeCustomizationItemProvider = new EAttributeCustomizationItemProvider(this);
        }

        return eAttributeCustomizationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.EReferenceCustomization} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected EReferenceCustomizationItemProvider eReferenceCustomizationItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.EReferenceCustomization}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createEReferenceCustomizationAdapter() {
        if (eReferenceCustomizationItemProvider == null) {
            eReferenceCustomizationItemProvider = new EReferenceCustomizationItemProvider(this);
        }

        return eReferenceCustomizationItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.SystemColor}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SystemColorItemProvider systemColorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.SystemColor}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSystemColorAdapter() {
        if (systemColorItemProvider == null) {
            systemColorItemProvider = new SystemColorItemProvider(this);
        }

        return systemColorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.InterpolatedColor} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected InterpolatedColorItemProvider interpolatedColorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.InterpolatedColor}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createInterpolatedColorAdapter() {
        if (interpolatedColorItemProvider == null) {
            interpolatedColorItemProvider = new InterpolatedColorItemProvider(this);
        }

        return interpolatedColorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.ColorStep}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ColorStepItemProvider colorStepItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.ColorStep}. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createColorStepAdapter() {
        if (colorStepItemProvider == null) {
            colorStepItemProvider = new ColorStepItemProvider(this);
        }

        return colorStepItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.FixedColor}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected FixedColorItemProvider fixedColorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.FixedColor}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createFixedColorAdapter() {
        if (fixedColorItemProvider == null) {
            fixedColorItemProvider = new FixedColorItemProvider(this);
        }

        return fixedColorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.UserFixedColor}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected UserFixedColorItemProvider userFixedColorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.UserFixedColor}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createUserFixedColorAdapter() {
        if (userFixedColorItemProvider == null) {
            userFixedColorItemProvider = new UserFixedColorItemProvider(this);
        }

        return userFixedColorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.Environment}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EnvironmentItemProvider environmentItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.Environment}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createEnvironmentAdapter() {
        if (environmentItemProvider == null) {
            environmentItemProvider = new EnvironmentItemProvider(this);
        }

        return environmentItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.SytemColorsPalette} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected SytemColorsPaletteItemProvider sytemColorsPaletteItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.SytemColorsPalette}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createSytemColorsPaletteAdapter() {
        if (sytemColorsPaletteItemProvider == null) {
            sytemColorsPaletteItemProvider = new SytemColorsPaletteItemProvider(this);
        }

        return sytemColorsPaletteItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.UserColorsPalette} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected UserColorsPaletteItemProvider userColorsPaletteItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.UserColorsPalette}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createUserColorsPaletteAdapter() {
        if (userColorsPaletteItemProvider == null) {
            userColorsPaletteItemProvider = new UserColorsPaletteItemProvider(this);
        }

        return userColorsPaletteItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.AnnotationEntry}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AnnotationEntryItemProvider annotationEntryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.AnnotationEntry}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createAnnotationEntryAdapter() {
        if (annotationEntryItemProvider == null) {
            annotationEntryItemProvider = new AnnotationEntryItemProvider(this);
        }

        return annotationEntryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.IdentifiedElement} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected IdentifiedElementItemProvider identifiedElementItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.IdentifiedElement}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createIdentifiedElementAdapter() {
        if (identifiedElementItemProvider == null) {
            identifiedElementItemProvider = new IdentifiedElementItemProvider(this);
        }

        return identifiedElementItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.ComputedColor}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComputedColorItemProvider computedColorItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.ComputedColor}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createComputedColorAdapter() {
        if (computedColorItemProvider == null) {
            computedColorItemProvider = new ComputedColorItemProvider(this);
        }

        return computedColorItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all
     * {@link org.eclipse.sirius.viewpoint.description.DAnnotationEntry} instances. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    protected DAnnotationEntryItemProvider dAnnotationEntryItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.DAnnotationEntry}. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createDAnnotationEntryAdapter() {
        if (dAnnotationEntryItemProvider == null) {
            dAnnotationEntryItemProvider = new DAnnotationEntryItemProvider(this);
        }

        return dAnnotationEntryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link org.eclipse.sirius.viewpoint.description.TypedVariable}
     * instances. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected TypedVariableItemProvider typedVariableItemProvider;

    /**
     * This creates an adapter for a {@link org.eclipse.sirius.viewpoint.description.TypedVariable}. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter createTypedVariableAdapter() {
        if (typedVariableItemProvider == null) {
            typedVariableItemProvider = new TypedVariableItemProvider(this);
        }

        return typedVariableItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class<?>) || (((Class<?>) type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public List<IChildCreationExtender> getChildCreationExtenders() {
        return childCreationExtenderManager.getChildCreationExtenders();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Collection<?> getNewChildDescriptors(Object object, EditingDomain editingDomain) {
        return childCreationExtenderManager.getNewChildDescriptors(object, editingDomain);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceLocator getResourceLocator() {
        return childCreationExtenderManager;
    }

    /**
     * This adds a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     */
    @Override
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void dispose() {
        if (groupItemProvider != null) {
            groupItemProvider.dispose();
        }
        if (viewpointItemProvider != null) {
            viewpointItemProvider.dispose();
        }
        if (metamodelExtensionSettingItemProvider != null) {
            metamodelExtensionSettingItemProvider.dispose();
        }
        if (javaExtensionItemProvider != null) {
            javaExtensionItemProvider.dispose();
        }
        if (dAnnotationItemProvider != null) {
            dAnnotationItemProvider.dispose();
        }
        if (decorationDescriptionsSetItemProvider != null) {
            decorationDescriptionsSetItemProvider.dispose();
        }
        if (semanticBasedDecorationItemProvider != null) {
            semanticBasedDecorationItemProvider.dispose();
        }
        if (genericDecorationDescriptionItemProvider != null) {
            genericDecorationDescriptionItemProvider.dispose();
        }
        if (customizationItemProvider != null) {
            customizationItemProvider.dispose();
        }
        if (vsmElementCustomizationItemProvider != null) {
            vsmElementCustomizationItemProvider.dispose();
        }
        if (vsmElementCustomizationReuseItemProvider != null) {
            vsmElementCustomizationReuseItemProvider.dispose();
        }
        if (eAttributeCustomizationItemProvider != null) {
            eAttributeCustomizationItemProvider.dispose();
        }
        if (eReferenceCustomizationItemProvider != null) {
            eReferenceCustomizationItemProvider.dispose();
        }
        if (systemColorItemProvider != null) {
            systemColorItemProvider.dispose();
        }
        if (interpolatedColorItemProvider != null) {
            interpolatedColorItemProvider.dispose();
        }
        if (colorStepItemProvider != null) {
            colorStepItemProvider.dispose();
        }
        if (fixedColorItemProvider != null) {
            fixedColorItemProvider.dispose();
        }
        if (userFixedColorItemProvider != null) {
            userFixedColorItemProvider.dispose();
        }
        if (environmentItemProvider != null) {
            environmentItemProvider.dispose();
        }
        if (sytemColorsPaletteItemProvider != null) {
            sytemColorsPaletteItemProvider.dispose();
        }
        if (userColorsPaletteItemProvider != null) {
            userColorsPaletteItemProvider.dispose();
        }
        if (annotationEntryItemProvider != null) {
            annotationEntryItemProvider.dispose();
        }
        if (identifiedElementItemProvider != null) {
            identifiedElementItemProvider.dispose();
        }
        if (computedColorItemProvider != null) {
            computedColorItemProvider.dispose();
        }
        if (dAnnotationEntryItemProvider != null) {
            dAnnotationEntryItemProvider.dispose();
        }
        if (typedVariableItemProvider != null) {
            typedVariableItemProvider.dispose();
        }
    }

}
